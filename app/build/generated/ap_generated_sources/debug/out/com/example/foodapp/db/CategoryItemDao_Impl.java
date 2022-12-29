package com.example.foodapp.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.foodapp.model.CategoryItem;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CategoryItemDao_Impl implements CategoryItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<CategoryItem> __insertionAdapterOfCategoryItem;

  public CategoryItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCategoryItem = new EntityInsertionAdapter<CategoryItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `categoryDb` (`id`,`idCategory`,`strCategory`,`strCategoryThumb`,`strCategoryDescription`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, CategoryItem value) {
        stmt.bindLong(1, value.getId());
        if (value.getIdCategory() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIdCategory());
        }
        if (value.getStrCategory() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStrCategory());
        }
        if (value.getStrCategoryThumb() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStrCategoryThumb());
        }
        if (value.getStrCategoryDescription() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getStrCategoryDescription());
        }
      }
    };
  }

  @Override
  public void insertCategoryListItem(final CategoryItem categoryItem) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCategoryItem.insert(categoryItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<CategoryItem>> getCategories() {
    final String _sql = "SELECT * FROM categoryDb";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"categoryDb"}, false, new Callable<List<CategoryItem>>() {
      @Override
      public List<CategoryItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfIdCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "idCategory");
          final int _cursorIndexOfStrCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "strCategory");
          final int _cursorIndexOfStrCategoryThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "strCategoryThumb");
          final int _cursorIndexOfStrCategoryDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "strCategoryDescription");
          final List<CategoryItem> _result = new ArrayList<CategoryItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final CategoryItem _item;
            _item = new CategoryItem();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpIdCategory;
            if (_cursor.isNull(_cursorIndexOfIdCategory)) {
              _tmpIdCategory = null;
            } else {
              _tmpIdCategory = _cursor.getString(_cursorIndexOfIdCategory);
            }
            _item.setIdCategory(_tmpIdCategory);
            final String _tmpStrCategory;
            if (_cursor.isNull(_cursorIndexOfStrCategory)) {
              _tmpStrCategory = null;
            } else {
              _tmpStrCategory = _cursor.getString(_cursorIndexOfStrCategory);
            }
            _item.setStrCategory(_tmpStrCategory);
            final String _tmpStrCategoryThumb;
            if (_cursor.isNull(_cursorIndexOfStrCategoryThumb)) {
              _tmpStrCategoryThumb = null;
            } else {
              _tmpStrCategoryThumb = _cursor.getString(_cursorIndexOfStrCategoryThumb);
            }
            _item.setStrCategoryThumb(_tmpStrCategoryThumb);
            final String _tmpStrCategoryDescription;
            if (_cursor.isNull(_cursorIndexOfStrCategoryDescription)) {
              _tmpStrCategoryDescription = null;
            } else {
              _tmpStrCategoryDescription = _cursor.getString(_cursorIndexOfStrCategoryDescription);
            }
            _item.setStrCategoryDescription(_tmpStrCategoryDescription);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
