package com.codepath.todolist;

import com.raizlabs.android.dbflow.annotation.*;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;
import java.util.UUID;


/**
 * Created by chenrangong on 8/1/17.
 */
@Table(database = MyDatabase.class)
public class Item extends BaseModel {

    @Column
    @PrimaryKey
    UUID id;

    @Column
    String content;

    @Column
    String priority;

    @Column
    Date dueDate;

    @Column
    Date creationDate;
}
