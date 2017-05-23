package com.example.baitap14;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

	 ArrayList<NhanVien>arrEmployee=new ArrayList<NhanVien>();
   	 NhanVienArrayAdapter adapter=null;
	 ListView lvNhanvien=null;
	 Button btnNhap;
	 ImageButton btnRemoveAll;
	 EditText editMa,editTen;
	 RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNhap=(Button) findViewById(R.id.btnNhap);
        btnRemoveAll=(ImageButton) findViewById(R.id.btndelete);
        editMa=(EditText) findViewById(R.id.editMa);
        editTen=(EditText) findViewById(R.id.editTen);
        genderGroup=(RadioGroup) findViewById(R.id.radioGroup1);
        lvNhanvien=(ListView) findViewById(R.id.lvnhanvien);
        arrEmployee=new ArrayList<NhanVien>();
        adapter=new NhanVienArrayAdapter(this,R.layout.item_layout,arrEmployee);
        lvNhanvien.setAdapter(adapter);
        btnNhap.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	        	xulyNhap();
	        }
        });
        btnRemoveAll.setOnClickListener(new OnClickListener() {
	        @Override
	        public void onClick(View arg0) {
	        	xulyXoa();
	        }
        });
        }
    
        public void xulyNhap()
        {
	        String ma=editMa.getText()+"";
	        String ten=editTen.getText()+"";
	        boolean gioitinh=false;
	        if(genderGroup.getCheckedRadioButtonId()==R.id.radNu)
	        	gioitinh=true;
	        NhanVien emp=new NhanVien();
	        emp.setId(ma);
	        emp.setName(ten);
	        emp.setGender(gioitinh);
	        arrEmployee.add(emp);
	        adapter.notifyDataSetChanged();
	        editMa.setText("");
	        editTen.setText("");
	        editMa.requestFocus();
        }
        
        public void xulyXoa()
        {
	        for(int i=lvNhanvien.getChildCount()-1;i>=0;i--)
	        {
		        View v=lvNhanvien.getChildAt(i);
		        CheckBox chk=(CheckBox) v.findViewById(R.id.chkitem);
		        if(chk.isChecked())
		        {
		        	arrEmployee.remove(i);
		        }
	        }
        adapter.notifyDataSetChanged();
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
