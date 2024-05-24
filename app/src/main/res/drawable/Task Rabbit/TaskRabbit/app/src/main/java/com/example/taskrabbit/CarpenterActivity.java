package com.example.taskrabbit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class CarpenterActivity extends AppCompatActivity {

    private final String[][] carpenter_detail =
            {
                    {"Sohan Pawar", "Shop Address: Katraj", "Experience: 8 Years", "Mobile No: 9876543210", "500"},
                    {"Vishal Patil", "Shop Address: Hinjawadi Phase 1", "Experience: 2 Years", "Mobile No: 8796541230", "700"},
                    {"Vedant Agarwal", "Shop Address: Hinjawadi Phase 2", "Experience: 3 Years", "Mobile No: 8976451320", "400"},
                    {"Aarav Patel", "Shop Address: Hinjawadi Phase 3", "Experience: 6 Years", "Mobile No: 7894561230", "500"},
                    {"Ishan Reddy", "Shop Address: Shivaji Nagar", "Experience: 10 Years", "Mobile No: 7984651230", "600"},
                    {"Rohan Mehta", "Shop Address: Bawada", "Experience: 1 Years", "Mobile No: 8679541320", "650"},
                    {"Yash Singh", "Shop Address: Swargate", "Experience: 6 Years", "Mobile No: 8297456310", "350"},
                    {"Vikram Joshi", "Shop Address: Bibwewadi", "Experience: 8 Years", "Mobile No: 8497563210", "450"},
            };

    ArrayList<HashMap<String, String>> list;
    HashMap<String, String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carpenteractivity);

        list = new ArrayList<>();
        for (String[] detail : carpenter_detail) {
            item = new HashMap<>();
            item.put("Line1", detail[0]);
            item.put("Line2", detail[1]);
            item.put("Line3", detail[2]);
            item.put("Line4", detail[3]);
            item.put("Line5", "Fees: " + detail[4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(
                this,
                list,
                R.layout.multy_lines,
                new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );

        ListView list1 = findViewById(R.id.listView);
        list1.setAdapter(sa);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent it = new Intent(CarpenterActivity.this, BookActivity.class);
                it.putExtra("text1", carpenter_detail[i][0]);
                it.putExtra("text2",carpenter_detail[i][3]);
                it.putExtra("text3",carpenter_detail[i][4]);
                startActivity(it);
            }
        });

    }
}