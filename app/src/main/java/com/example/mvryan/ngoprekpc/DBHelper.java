package com.example.mvryan.ngoprekpc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvryan on 26/12/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String LOG = "DBHelper";
    private static final int DB_VER = 1;
    private static final String DB_NAME = "komponenPC";

    private static final  String TABLE_NAME="product";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nama";
    private static final String KEY_PRICE = "harga";
    private static final String KEY_DESC = "deskripsi";
    private static final String KEY_IMAGE = "id_image";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+
                KEY_ID+" INTEGER PRIMARY KEY,"+
                KEY_NAME+"TEXT,"+
                KEY_IMAGE+"INTEGER,"+
                KEY_PRICE+"DOUBLE,"+
                KEY_DESC+"TEXT"
                +")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        onCreate(sqLiteDatabase);
    }

    public void insertData(Product product){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,product.getNama());
        values.put(KEY_IMAGE,product.getId_image());
        values.put(KEY_PRICE,product.getHarga());
        values.put(KEY_DESC,product.getDeskripsi());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public Product getDataById(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[]{
                KEY_NAME,KEY_PRICE,KEY_IMAGE,KEY_DESC
        },KEY_ID+"=?",
                new String[]{String.valueOf(id)},
                null,null,null,null);
        if (cursor!=null){
            cursor.moveToFirst();
        }

        Product product = new Product(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                Integer.parseInt(cursor.getString(3)),
                cursor.getString(4));

        return product;
    }

    public List<Product> getAllProduct(){
        List<Product> productList = new ArrayList<Product>();

        String selectQuery = "SELECT * FROM"+TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do {
                {
                    Product product = new Product();
                    product.setId(Integer.parseInt(cursor.getString(0)));
                    product.setNama(cursor.getString(1));
                    product.setHarga(cursor.getString(2));
                    product.setId_image(Integer.parseInt(cursor.getString(3)));
                    product.setDeskripsi(cursor.getString(4));
                }
            }while (cursor.moveToNext());
        }
        return productList;
    }

    public int getProductCount(){
        String countQuery = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();

        return cursor.getCount();
    }

    public int updateProduct(Product product){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,product.getNama());
        values.put(KEY_IMAGE,product.getId_image());
        values.put(KEY_PRICE,product.getHarga());
        values.put(KEY_DESC,product.getDeskripsi());

        return db.update(TABLE_NAME,values,KEY_ID+"=?",
                new String[]{String.valueOf(product.getId())});
    }

    public void removeDataById(Product product){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,KEY_ID+"=?",
                new String[]{String.valueOf(product.getId())});
        db.close();
    }
}
