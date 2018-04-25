package humanity.nishcha.com.humanity0;

import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nitin on 4/26/2018.
 */

public class Databasehandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "humanity";
    private   SQLiteDatabase sqLiteDatabase;
    private Context context;
    private  String selectQuery;
    private Cursor cursor;
    private static final String KEY_ID = "id";
    private static final String TABLE_ADMIN="admin";
    private static final String TABLE_USER="user";
    private static final String TABLE_POST="post";
    private static final String TABLE_RESPONSE="response";
    private static final String ADMIN_NAME="name";
    private static final String ADMIN_EMAIL="email";
    private static final String ADMIN_NGO="ngo";
    private static final String ADMIN_ADDRESS="address";
    private static final String ADMIN_PHONE="phone";
    private static final String ADMIN_PASSWORD="password";
    private static final String USER_NAME="name";
    private static final String USER_EMAIL="email";
    private static final String USER_ADDRESS="address";
    private static final String USER_PHONE="phone";
    private static final String USER_PASSWORD="password";
    private static final String POST_ADMIN_ID="adminid";
    private static final String POST_VOLUNTER="volunter";
    private static final String POST_LOCATION="location";
    private static final String POST_DATE="date";
    private static final String POST_TIME="time";
    private static final String POST_DURATION="duration";


    private static final String CREATE_ADMIN_TABLE="CREATE TABLE "+TABLE_ADMIN+"("+KEY_ID+" INTEGER PRIMARY KEY,"+ADMIN_NAME+" TEXT,"+ADMIN_EMAIL+" TEXT,"+ADMIN_NGO+" TEXT,"+ADMIN_ADDRESS+" TEXT,"+ADMIN_PHONE+" TEXT,"+ADMIN_PASSWORD+" TEXT"+")";
    private static final String CREATE_USER_TABLE="CREATE TABLE "+TABLE_USER+"("+KEY_ID+" INTEGER PRIMARY KEY,"+USER_NAME+" TEXT,"+USER_EMAIL+" TEXT,"+USER_ADDRESS+" TEXT,"+USER_PHONE+" TEXT,"+USER_PASSWORD+" TEXT"+") ";
    private static final String CREATE_POST_TABLE="CREATE TABLE "+TABLE_POST+"("+KEY_ID+" INTEGER PRIMARY KEY,"+POST_ADMIN_ID+" INTEGER,"+POST_VOLUNTER+" TEXT,"+POST_LOCATION+" TEXT,"+POST_DATE+" TEXT,"+POST_TIME+" TEXT,"+POST_DURATION+" TEXT"+") ";
    private static final String CREATE_RESPONE_TABLE="CREATE TABLE "+TABLE_RESPONSE+"("+KEY_ID+" INTEGER PRIMARY KEY,"+POST_ADMIN_ID+" INTEGER,"+POST_VOLUNTER+" TEXT,"+POST_LOCATION+" TEXT,"+POST_DATE+" TEXT,"+POST_TIME+" TEXT,"+POST_DURATION+" TEXT"+") ";

    public Databasehandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ADMIN_TABLE);
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_POST_TABLE);
        db.execSQL(CREATE_RESPONE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addResponse(Post post,Databasehandler db){
        sqLiteDatabase=db.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(POST_ADMIN_ID,post.getId());
        contentValues.put(POST_VOLUNTER,post.getVolunter());
        contentValues.put(POST_LOCATION,post.getLocation());
        contentValues.put(POST_DATE,post.getDate());
        contentValues.put(POST_TIME,post.getTime());
        contentValues.put(POST_DURATION,post.getDuratiom());
        long flag= sqLiteDatabase.insert(TABLE_RESPONSE, null,contentValues);
        sqLiteDatabase.close();
        return flag;
    }

    public long addPost(Post post,Databasehandler db){
        sqLiteDatabase=db.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(POST_ADMIN_ID,post.getId());
        contentValues.put(POST_VOLUNTER,post.getVolunter());
        contentValues.put(POST_LOCATION,post.getLocation());
        contentValues.put(POST_DATE,post.getDate());
        contentValues.put(POST_TIME,post.getTime());
        contentValues.put(POST_DURATION,post.getDuratiom());
        long flag= sqLiteDatabase.insert(TABLE_POST, null,contentValues);
        sqLiteDatabase.close();
        return flag;
    }

    public long addAdmin(Admin admin,Databasehandler db){
        sqLiteDatabase=db.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ADMIN_NAME,admin.getName());
        contentValues.put(ADMIN_EMAIL,admin.getEmail());
        contentValues.put(ADMIN_NGO,admin.getNgo());
        contentValues.put(ADMIN_ADDRESS,admin.getAddress());
        contentValues.put(ADMIN_PHONE,admin.getPhone());
        contentValues.put(ADMIN_PASSWORD,admin.getPassword());
        long flag= sqLiteDatabase.insert(TABLE_ADMIN, null,contentValues);
        sqLiteDatabase.close();
        return flag;

    }

    public long addUser(User user,Databasehandler db){
        sqLiteDatabase=db.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(USER_NAME,user.getName());
        contentValues.put(USER_EMAIL,user.getEmail());
        contentValues.put(USER_ADDRESS,user.getAddress());
        contentValues.put(USER_PHONE,user.getPhone());
        contentValues.put(USER_PASSWORD,user.getPassword());
        long flag= sqLiteDatabase.insert(TABLE_USER, null,contentValues);
        sqLiteDatabase.close();
        return flag;

    }

    public ArrayList<Post> readallResponse(Databasehandler db){
        ArrayList<Post> arrayList=new ArrayList<>();
        selectQuery = "SELECT  * FROM " + TABLE_RESPONSE;
        sqLiteDatabase =db.getWritableDatabase();
        cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Post post=new Post();
                post.setId(cursor.getInt(1));
                post.setVolunter(cursor.getString(2));
                post.setLocation(cursor.getString(3));
                post.setDate(cursor.getString(4));
                post.setTime(cursor.getString(5));
                post.setDuratiom(cursor.getString(6));
                arrayList.add(post);
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return arrayList;

    }

    public ArrayList<Post> readallPost(Databasehandler db){
        ArrayList<Post> arrayList=new ArrayList<>();
        selectQuery = "SELECT  * FROM " + TABLE_POST;
        sqLiteDatabase =db.getWritableDatabase();
        cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Post post=new Post();
                post.setId(cursor.getInt(1));
                post.setVolunter(cursor.getString(2));
                post.setLocation(cursor.getString(3));
                post.setDate(cursor.getString(4));
                post.setTime(cursor.getString(5));
                post.setDuratiom(cursor.getString(6));
                arrayList.add(post);
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return arrayList;

    }

    public ArrayList<Admin> readallAdmin(Databasehandler db){
        ArrayList<Admin> arrayList=new ArrayList<>();
        selectQuery = "SELECT  * FROM " + TABLE_ADMIN;
        sqLiteDatabase =db.getWritableDatabase();
        cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Admin admin=new Admin();
               admin.setId(cursor.getInt(0));
               admin.setName(cursor.getString(1));
               admin.setEmail(cursor.getString(2));
               admin.setNgo(cursor.getString(3));
               admin.setAddress(cursor.getString(4));
               admin.setPhone(cursor.getString(5));
               admin.setPassword(cursor.getString(6));
               arrayList.add(admin);
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return arrayList;

    }

    public ArrayList<User> readalluser(Databasehandler db){
        ArrayList<User> arrayList=new ArrayList<>();
        selectQuery = "SELECT  * FROM " + TABLE_USER;
        sqLiteDatabase =db.getWritableDatabase();
        cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                User user=new User();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setAddress(cursor.getString(3));
                user.setPhone(cursor.getString(4));
                user.setPassword(cursor.getString(5));
                arrayList.add(user);
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return arrayList;


    }
}
