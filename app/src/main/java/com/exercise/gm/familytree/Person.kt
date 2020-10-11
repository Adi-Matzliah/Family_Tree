package com.exercise.gm.familytree

data class Person(val id:Int, val name:String, val gender: Gender, val isOriginallyBelongedToThisFamilyTree: Boolean = true, val mother: Person? = null, val father: Person? = null, var marriedWith: Person? = null, var kids: MyList<Person>? = null) {

    fun addKid(kid: Person) {
        if (kids == null) {
            kids = MyList()
        }
        kids?.let{ it.add(kid) }
    }

    fun removeKids() {
        kids = null
    }

    fun divorce() {
        marriedWith = null
    }
}