/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.raghu.phonebook.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import com.example.raghu.phonebook.db.dao.ContactDao
import com.example.raghu.phonebook.entity.ContactEntity


@Database(entities = arrayOf(ContactEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {

         val DATABASE_NAME = "phone-book-contacts-db"
    }

}
