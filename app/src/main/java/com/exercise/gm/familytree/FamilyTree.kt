package com.exercise.gm.familytree

import android.util.Log

class FamilyTree : Tree<Person>() {

    private lateinit var root: Person

    override fun createFamilyTree(
        motherId: Int,
        motherName: String,
        fatherId: Int,
        fatherName: String
    ) {
        val parent1 = Person(fatherId, fatherName, Gender.MALE)
        val parent2 = Person(motherId, motherName, Gender.FEMALE)
        parent1.marriedWith = parent2
        parent2.marriedWith = parent1
        root = parent1
    }

    override fun haveAKid(motherId: Int, fatherId: Int, kidId: Int, kidName: String, kidGender: Gender) {
        val person = findIntegralParent(root, motherId, fatherId)
        person?.let { parent ->
            val kid = Person(kidId, kidName, kidGender)
            parent.addKid(kid)
        }
    }

    override fun marry(id: Int, otherId: Int, otherName: String, otherGender: Gender) {
        val person = findPerson(root, id)
        val whomMarriedWith = Person(otherId, otherName, otherGender, false)
        person?.let {
            it.marriedWith = whomMarriedWith
        }
        whomMarriedWith.marriedWith = person
    }

    override fun divorce(motherId: Int, fatherId: Int, custody: Custody) {
        val parentWhoStaysWithTheKids = findPerson(root, if (custody == Custody.FATHER) fatherId else motherId)
        parentWhoStaysWithTheKids?.let {
            if (!it.isOriginallyBelongedToThisFamilyTree) {
                it.removeKids()
            }
            parentWhoStaysWithTheKids.marriedWith = null
            it.divorce()
        }
    }

    override fun show() {
        val ancestor = root
        printPersonTree(ancestor)
    }

    private fun printPersonTree(person: Person) {
        Log.d(TAG, "# Ancestor name: ${person.name} Gender: ${person.gender}")
        val whomMarriedWith = person.marriedWith
        Log.d(TAG,"# Married with: ${whomMarriedWith?.name ?: "N/A"}")
        val kids = person.kids
        kids?.let {
            for (i in 0 until kids.size()) {
                kids[i]?.let { descendant ->
                    printPersonTree(descendant)
                }
            }
        }
    }

    private fun findIntegralParent(root: Person, parentOneId: Int, parentTwoId: Int?)  : Person? {
        val parent1 = findPerson(root, parentOneId)
        if ( ((parent1 == null || !parent1.isOriginallyBelongedToThisFamilyTree) && parentTwoId != null) ) {
            return findPerson(root, parentTwoId)
        }
        return parent1
    }


    private fun findPerson(root: Person, personId: Int) : Person? {
        when {
            root.id == personId -> {
                return root
            }
            root.marriedWith != null && root.marriedWith?.id == personId -> {
                return root.marriedWith
            }
            else -> {
                val kids = root.kids
                kids?.let {
                    for (i in 0 until kids.size()) {
                        kids[i]?.let {
                            findPerson(it, personId)
                        }
                    }
                }
                return null
            }
        }
    }

    companion object {
        const val TAG: String = "FamilyTree"
    }
}