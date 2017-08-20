package com.codepath.todolist;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    List<Item> items;
    ItemAdapter itemsAdaper;
    ListView lvItems;
    private final int REQUEST_CODE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FlowManager.init(new FlowConfig.Builder(this).build());

        lvItems = (ListView)findViewById(R.id.lvItems);
        items = queryAll();
        itemsAdaper = new ItemAdapter(this, items);
        lvItems.setAdapter(itemsAdaper);
        setupListViewListener();
        editItemListener();
    }

    public void onAddItem(View v){
        EditText etNewItem = (EditText)findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();

        System.out.println(itemText);

        Item newItem = new Item();
        newItem.id = UUID.randomUUID();
        newItem.content = itemText;
        newItem.creationDate = new Date();
        newItem.priority = "";
        newItem.save();

        itemsAdaper.add(newItem);
        etNewItem.setText("");
    }

    public List<Item> queryAll(){
        List<Item> allItems = SQLite.select().from(Item.class).orderBy(Item_Table.creationDate, true).queryList();
        return allItems;
    }

    private void setupListViewListener(){
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id){
                Item deletedItem = items.get(pos);
                deletedItem.delete();
                items.remove(pos);
                itemsAdaper.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void editItemListener(){
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int pos, long id){
                Item editedItem = items.get(pos);
                showEditDialog(editedItem);
            }
        });
    }

    private void showEditDialog(Item item) {
        FragmentManager fm = getSupportFragmentManager();
        EditItemDialogFragment editNameDialogFragment = EditItemDialogFragment.newInstance(item);
        editNameDialogFragment.show(fm, "fragment_edit_item");
        editNameDialogFragment.editSaveListener = new EditItemDialogFragment.EditSaveListener() {
            @Override
            public void onEditSave(Item item, EditItemDialogFragment editItemDialogFragment){
                item.save();
                itemsAdaper.notifyDataSetChanged();
                editItemDialogFragment.dismiss();
            }
        };
    }



}

