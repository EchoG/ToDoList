# Pre-work - *ToDoList*

**ToDoList** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Chenran Gong**

Time spent: **20** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [x] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [x] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [x] Add support for completion due dates for todo items (and display within listview item)
* [x] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [x] Add support for selecting the priority of each todo item (and display in listview item)
* [x] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [x] Add splash screen when starting the app

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/link/to/your/gif/file.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** 
I like Android app development platform. It's stable and easy to use. 

Compare layouts and user interface between iOS and Android: For iOS, it has two ways: auto layout constraints and interface builder. For Android, every object can be set in XML files and there are also different layout types, like linearlayout, relativelayout, etc... After developing apps on both platform, actually I like Android's approach to layout and user interface more, which is more convenient. I can set all kinds of attributs of every UI object in the layout XML files, which is very clear and will not mix with activity code.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:**
Adapter is like a connector transmit between a set of data and view. It is responsible for provideing child views for each data itme in AdapterViews and showing each data item on the view. You can get each item as a view through adapter. From the official android developer website, it defines adaper: An Adapter object acts as a bridge between an AdapterView and the underlying data for that view. The Adapter provides access to the data items. The Adapter is also responsible for making a View for each item in the data set.

Why adapter is important? Adapter can show the data on the UI view and it can also show the changes of data. Adapter is way that data source can be populated to the UI and it can control how the data will be displayed on the view, especially when the data is a collection of data, like array, list and databases related data. You can also create your own custom adapter to display the data in your own way.

'GetView' method of the 'ArrayAdapter' displays the data at a specific posion. The 'convertView' means the existing view to reuse. If it is null, which means no view to resue, you have to inflate a new view.

## Notes

..* The listener of save button of the edit dialog is difficult for me to understand at first. I spent hours to understant the basic concept of callback and the implementation of listener. It is worth the time because it is an important concept that is used in many places, like the callbacks in Node.js, the delegate in Swift, and so on. When I understood and implemented the listener in this project, I found I undertood the principles of callbacks in Node.js and delegate in Swift better. 

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
