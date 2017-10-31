package a0x7e1.stravel;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {

    public static final String tableName = "stamp";
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    //테이블 생성
    public void createTable(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE " + tableName + "(num int, status int)";
        try
        {
            db.execSQL(sql);
        }
        catch (SQLException e)
        {
        }
        db.beginTransaction();

        try
        {
            for(int i=0;i<14;i++) {
                sql = "insert into " + tableName + "(num, status)" + " values(" + i + ", 0)";
                db.execSQL(sql);
            }
            db.setTransactionSuccessful();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            db.endTransaction();
        }
    }

    //정보 업데이트
    public void updateStatus(SQLiteDatabase db, int num)
    {
        db.beginTransaction();
        try
        {
            String sql = "update " + tableName + " set status=1 where num=" + num;
            db.execSQL(sql);
            db.setTransactionSuccessful();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            db.endTransaction();
        }
    }

    //정보 초기화
    public void deleteStatus(SQLiteDatabase db)
    {
        db.beginTransaction();
        try
        {
            String sql = "delete from "+tableName;
            db.execSQL(sql);
            db.setTransactionSuccessful();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            db.endTransaction();
        }
        createTable(getWritableDatabase());
    }

    //정보 출력
    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM stamp", null);
        while (cursor.moveToNext()) {
            result += cursor.getInt(0)
                    + " : "
                    + cursor.getInt(1) +"\n";
        }
        return result;
    }

    //STATUS 보내주기
    public int getStatus(int num) {

        SQLiteDatabase db = getReadableDatabase();
        int a=0;

        // 값을 읽어옴
        Cursor c = db.rawQuery("SELECT * FROM " + tableName + " where num = " + num, null);
        while (c.moveToNext()) {
            a = c.getInt(1);
        }
        return a;
    }
}