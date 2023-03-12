package com.example.news.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    static final String dbName = "NewsData";
    static final int dbVision = 2;
    public DbHelper(@Nullable Context context) {
        super(context, dbName, null, dbVision);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_news = "create table News(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, link TEXT NOT NULL)";
        db.execSQL(table_news);

        String data = "INSERT INTO News(name, link) VALUES " +
                "('Công Nghệ', 'https://vtv.vn/cong-nghe.rss')," +
                "('Thế Giới', 'https://vtv.vn/the-gioi/the-gioi-do-day.rss')," +
                "('Điện Ảnh', 'https://vtv.vn/van-hoa-giai-tri/dien-anh.rss')," +
                "('Bóng Đá', 'https://vtv.vn/the-thao/bong-da.rss')," +
                "('Du Lịch', 'https://vtv.vn/doi-song/du-lich.rss')," +
                "('Thời Tiết', 'https://vtv.vn/du-bao-thoi-tiet.rss')";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        onCreate(db);
    }
}
