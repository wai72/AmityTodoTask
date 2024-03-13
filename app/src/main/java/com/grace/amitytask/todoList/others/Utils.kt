package com.grace.amitytask.todoList.others

object Utils {
    fun getTodoDataFromJsonFile(link: String) : String{
        val basedLink = "https://www.google.com/s2/favicons?sz=64&domain_url="
        return basedLink+link;
    }

}