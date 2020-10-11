package com.exercise.gm.familytree

interface IFamilyTree {
    fun createFamilyTree(motherId:Int, motherName: String, fatherId: Int, fatherName: String)

    fun haveAKid(motherId:Int, fatherId: Int, kidId: Int, kidName: String, kidGender: Gender)

    fun marry(id: Int, otherId: Int, otherName: String, otherGender: Gender)

    fun divorce(motherId: Int, fatherId: Int, custody: Custody)

    fun show()
}