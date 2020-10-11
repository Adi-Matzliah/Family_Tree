package com.exercise.gm.familytree

data class Node<T>(var father: Person? = null, var mother: Person? = null, var kids: MyList<Person>? = null) {

}