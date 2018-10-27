package com.example.easykt.easykt

class Topic {
    private lateinit var name: String

    private var levelList : MutableList<Level> = mutableListOf()

    constructor(name: String, levelList: MutableList<Level>)
    {
        this.name = name
        this.levelList = levelList
    }

    public fun getName() : String{
        return name
    }

    public fun setName(name: String){
        this.name = name
    }

    public fun getLevelList(): MutableList<Level>
    {
        return levelList
    }

    public fun setLevelList(levelList: MutableList<Level>){
        this.levelList = levelList
    }
}