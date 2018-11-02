package com.example.easykt.easykt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ActivityTutorial : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        var tutorialType : String = intent.getStringExtra("TutorialToGo")

        if (tutorialType == "Basic Types") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = BegBasicTypesFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Control Flow") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = BegControlFlowFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Returns and Jumps") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = BegReturnsAndJumpsFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Classes and Inheritance") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = BegClassesAndInheritanceFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Properties and Fields") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = BegPropertiesAndFieldFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Interfaces") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = IntInterfacesFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Visibility Modifiers") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = IntVisibilityModifiersFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Data Classes") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = IntDataClassesFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Generics") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = IntGenericsFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Objects") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = IntObjectsFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Functions") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = IntFunctionsFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Lambdas") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = IntLambdasFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Collection") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = IntCollectionFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Exceptions") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = IntExceptionsFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Extensions") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = AdvExtensionsFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Sealed Classes") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = AdvSealedClassesFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Inline Classes") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = AdvInlineClassesFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Destructuring Declarations") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = AdvDestructuringDeclarationsFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Operator overloading") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = AdvOperatorOverloadingFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

        if (tutorialType == "Type-Safe Builders") {
            val fragmentManager = supportFragmentManager
            val transaction = fragmentManager.beginTransaction()
            val fragment1 = AdvTypeSafeBuildersFragment()
            transaction.add(R.id.tutFrameLayout, fragment1)
            transaction.commit()
        }

    }
}
