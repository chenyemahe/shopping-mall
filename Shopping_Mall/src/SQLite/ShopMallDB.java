package SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ShopMallDB extends SQLiteOpenHelper {  
    private final static String DATABASE_NAME = "Quaker_bridge_Mall.db";  
    private final static int DATABASE_VERSION = 1;  
    private final static String TABLE_NAME = "UserFavouriteItem_table";  
    public final static String ITEM_ID = "book_id";  
    public final static String ITEM_NAME = "book_name";  
    public final static String ITEM_SHOP_NAME = "book_author";  
      
    public ShopMallDB(Context context) {  
      // TODO Auto-generated constructor stub  
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
  }  
  //Create table  
  @Override  
  public void onCreate(SQLiteDatabase db) {  
        String sql = "CREATE TABLE " + TABLE_NAME + " (" + ITEM_ID  
          + " INTEGER primary key autoincrement, " + ITEM_NAME + " text, "+  ITEM_SHOP_NAME +" text);";  
        db.execSQL(sql);  
  }  
  @Override  
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  
      String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;  
      db.execSQL(sql);  
      onCreate(db);  
  }  
    
  public Cursor select() {  
      SQLiteDatabase db = this.getReadableDatabase();  
      Cursor cursor = db  
              .query(TABLE_NAME, null, null, null, null, null, null);  
      return cursor;  
  }  
  //insert
   public long insert(String bookname,String author)  
    {  
      SQLiteDatabase db = this.getWritableDatabase();  
      /* ContentValues */  
      ContentValues cv = new ContentValues();  
      cv.put(ITEM_NAME, bookname);  
      cv.put(ITEM_SHOP_NAME, author);  
      long row = db.insert(TABLE_NAME, null, cv);  
      return row;  
    }  
   //delete 
    public void delete(int id)  
    {  
      SQLiteDatabase db = this.getWritableDatabase();  
      String where = ITEM_ID + " = ?";  
      String[] whereValue ={ Integer.toString(id) };  
      db.delete(TABLE_NAME, where, whereValue);  
    }  
    //update  
    public void update(int id, String bookname,String author)  
    {  
      SQLiteDatabase db = this.getWritableDatabase();  
      String where = ITEM_ID + " = ?";  
      String[] whereValue = { Integer.toString(id) };  
      
      ContentValues cv = new ContentValues();  
      cv.put(ITEM_NAME, bookname);  
      cv.put(ITEM_SHOP_NAME, author);  
      db.update(TABLE_NAME, cv, where, whereValue);  
    }  
}  