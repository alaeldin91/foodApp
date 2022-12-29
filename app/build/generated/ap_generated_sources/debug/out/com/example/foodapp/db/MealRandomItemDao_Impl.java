package com.example.foodapp.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.foodapp.model.MealItem;
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
public final class MealRandomItemDao_Impl implements MealRandomItemDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MealItem> __insertionAdapterOfMealItem;

  public MealRandomItemDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMealItem = new EntityInsertionAdapter<MealItem>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `mealDb` (`id`,`idMeal`,`strMeal`,`strCategory`,`strArea`,`strInstructions`,`strMealThumb`,`strTags`,`strYoutube`,`strIngredient1`,`strIngredient2`,`strIngredient3`,`strIngredient4`,`strIngredient5`,`strIngredient6`,`strIngredient7`,`strIngredient8`,`strIngredient9`,`strIngredient10`,`strIngredient11`,`strIngredient12`,`strIngredient13`,`strIngredient14`,`strIngredient15`,`strIngredient16`,`strIngredient17`,`strIngredient18`,`strIngredient19`,`strIngredient20`,`strMeasure1`,`strMeasure2`,`strMeasure3`,`strMeasure4`,`strMeasure5`,`strMeasure6`,`strMeasure7`,`strMeasure8`,`strMeasure9`,`strMeasure10`,`strMeasure11`,`strMeasure12`,`strMeasure13`,`strMeasure14`,`strMeasure15`,`strMeasure16`,`strMeasure17`,`strMeasure18`,`strMeasure19`,`strMeasure20`,`strSource`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, MealItem value) {
        stmt.bindLong(1, value.getId());
        if (value.getIdMeal() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIdMeal());
        }
        if (value.getStrMeal() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStrMeal());
        }
        if (value.getStrCategory() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStrCategory());
        }
        if (value.getStrArea() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getStrArea());
        }
        if (value.getStrInstructions() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getStrInstructions());
        }
        if (value.getStrMealThumb() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getStrMealThumb());
        }
        if (value.getStrTags() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getStrTags());
        }
        if (value.getStrYoutube() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStrYoutube());
        }
        if (value.getStrIngredient1() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getStrIngredient1());
        }
        if (value.getStrIngredient2() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getStrIngredient2());
        }
        if (value.getStrIngredient3() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getStrIngredient3());
        }
        if (value.getStrIngredient4() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getStrIngredient4());
        }
        if (value.getStrIngredient5() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getStrIngredient5());
        }
        if (value.getStrIngredient6() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getStrIngredient6());
        }
        if (value.getStrIngredient7() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getStrIngredient7());
        }
        if (value.getStrIngredient8() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getStrIngredient8());
        }
        if (value.getStrIngredient9() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getStrIngredient9());
        }
        if (value.getStrIngredient10() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getStrIngredient10());
        }
        if (value.getStrIngredient11() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getStrIngredient11());
        }
        if (value.getStrIngredient12() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getStrIngredient12());
        }
        if (value.getStrIngredient13() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getStrIngredient13());
        }
        if (value.getStrIngredient14() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getStrIngredient14());
        }
        if (value.getStrIngredient15() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getStrIngredient15());
        }
        if (value.getStrIngredient16() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getStrIngredient16());
        }
        if (value.getStrIngredient17() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getStrIngredient17());
        }
        if (value.getStrIngredient18() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getStrIngredient18());
        }
        if (value.getStrIngredient19() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getStrIngredient19());
        }
        if (value.getStrIngredient20() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getStrIngredient20());
        }
        if (value.getStrMeasure1() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getStrMeasure1());
        }
        if (value.getStrMeasure2() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getStrMeasure2());
        }
        if (value.getStrMeasure3() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getStrMeasure3());
        }
        if (value.getStrMeasure4() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getStrMeasure4());
        }
        if (value.getStrMeasure5() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getStrMeasure5());
        }
        if (value.getStrMeasure6() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getStrMeasure6());
        }
        if (value.getStrMeasure7() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getStrMeasure7());
        }
        if (value.getStrMeasure8() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getStrMeasure8());
        }
        if (value.getStrMeasure9() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getStrMeasure9());
        }
        if (value.getStrMeasure10() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, value.getStrMeasure10());
        }
        if (value.getStrMeasure11() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindString(40, value.getStrMeasure11());
        }
        if (value.getStrMeasure12() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindString(41, value.getStrMeasure12());
        }
        if (value.getStrMeasure13() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindString(42, value.getStrMeasure13());
        }
        if (value.getStrMeasure14() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, value.getStrMeasure14());
        }
        if (value.getStrMeasure15() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindString(44, value.getStrMeasure15());
        }
        if (value.getStrMeasure16() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindString(45, value.getStrMeasure16());
        }
        if (value.getStrMeasure17() == null) {
          stmt.bindNull(46);
        } else {
          stmt.bindString(46, value.getStrMeasure17());
        }
        if (value.getStrMeasure18() == null) {
          stmt.bindNull(47);
        } else {
          stmt.bindString(47, value.getStrMeasure18());
        }
        if (value.getStrMeasure19() == null) {
          stmt.bindNull(48);
        } else {
          stmt.bindString(48, value.getStrMeasure19());
        }
        if (value.getStrMeasure20() == null) {
          stmt.bindNull(49);
        } else {
          stmt.bindString(49, value.getStrMeasure20());
        }
        if (value.getStrSource() == null) {
          stmt.bindNull(50);
        } else {
          stmt.bindString(50, value.getStrSource());
        }
      }
    };
  }

  @Override
  public void insertRandomMealItem(final MealItem mealItem) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMealItem.insert(mealItem);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<MealItem>> getMeal() {
    final String _sql = "SELECT * FROM mealDb";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"mealDb"}, false, new Callable<List<MealItem>>() {
      @Override
      public List<MealItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfIdMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "idMeal");
          final int _cursorIndexOfStrMeal = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeal");
          final int _cursorIndexOfStrCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "strCategory");
          final int _cursorIndexOfStrArea = CursorUtil.getColumnIndexOrThrow(_cursor, "strArea");
          final int _cursorIndexOfStrInstructions = CursorUtil.getColumnIndexOrThrow(_cursor, "strInstructions");
          final int _cursorIndexOfStrMealThumb = CursorUtil.getColumnIndexOrThrow(_cursor, "strMealThumb");
          final int _cursorIndexOfStrTags = CursorUtil.getColumnIndexOrThrow(_cursor, "strTags");
          final int _cursorIndexOfStrYoutube = CursorUtil.getColumnIndexOrThrow(_cursor, "strYoutube");
          final int _cursorIndexOfStrIngredient1 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient1");
          final int _cursorIndexOfStrIngredient2 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient2");
          final int _cursorIndexOfStrIngredient3 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient3");
          final int _cursorIndexOfStrIngredient4 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient4");
          final int _cursorIndexOfStrIngredient5 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient5");
          final int _cursorIndexOfStrIngredient6 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient6");
          final int _cursorIndexOfStrIngredient7 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient7");
          final int _cursorIndexOfStrIngredient8 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient8");
          final int _cursorIndexOfStrIngredient9 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient9");
          final int _cursorIndexOfStrIngredient10 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient10");
          final int _cursorIndexOfStrIngredient11 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient11");
          final int _cursorIndexOfStrIngredient12 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient12");
          final int _cursorIndexOfStrIngredient13 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient13");
          final int _cursorIndexOfStrIngredient14 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient14");
          final int _cursorIndexOfStrIngredient15 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient15");
          final int _cursorIndexOfStrIngredient16 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient16");
          final int _cursorIndexOfStrIngredient17 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient17");
          final int _cursorIndexOfStrIngredient18 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient18");
          final int _cursorIndexOfStrIngredient19 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient19");
          final int _cursorIndexOfStrIngredient20 = CursorUtil.getColumnIndexOrThrow(_cursor, "strIngredient20");
          final int _cursorIndexOfStrMeasure1 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure1");
          final int _cursorIndexOfStrMeasure2 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure2");
          final int _cursorIndexOfStrMeasure3 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure3");
          final int _cursorIndexOfStrMeasure4 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure4");
          final int _cursorIndexOfStrMeasure5 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure5");
          final int _cursorIndexOfStrMeasure6 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure6");
          final int _cursorIndexOfStrMeasure7 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure7");
          final int _cursorIndexOfStrMeasure8 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure8");
          final int _cursorIndexOfStrMeasure9 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure9");
          final int _cursorIndexOfStrMeasure10 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure10");
          final int _cursorIndexOfStrMeasure11 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure11");
          final int _cursorIndexOfStrMeasure12 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure12");
          final int _cursorIndexOfStrMeasure13 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure13");
          final int _cursorIndexOfStrMeasure14 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure14");
          final int _cursorIndexOfStrMeasure15 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure15");
          final int _cursorIndexOfStrMeasure16 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure16");
          final int _cursorIndexOfStrMeasure17 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure17");
          final int _cursorIndexOfStrMeasure18 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure18");
          final int _cursorIndexOfStrMeasure19 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure19");
          final int _cursorIndexOfStrMeasure20 = CursorUtil.getColumnIndexOrThrow(_cursor, "strMeasure20");
          final int _cursorIndexOfStrSource = CursorUtil.getColumnIndexOrThrow(_cursor, "strSource");
          final List<MealItem> _result = new ArrayList<MealItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final MealItem _item;
            _item = new MealItem();
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpIdMeal;
            if (_cursor.isNull(_cursorIndexOfIdMeal)) {
              _tmpIdMeal = null;
            } else {
              _tmpIdMeal = _cursor.getString(_cursorIndexOfIdMeal);
            }
            _item.setIdMeal(_tmpIdMeal);
            final String _tmpStrMeal;
            if (_cursor.isNull(_cursorIndexOfStrMeal)) {
              _tmpStrMeal = null;
            } else {
              _tmpStrMeal = _cursor.getString(_cursorIndexOfStrMeal);
            }
            _item.setStrMeal(_tmpStrMeal);
            final String _tmpStrCategory;
            if (_cursor.isNull(_cursorIndexOfStrCategory)) {
              _tmpStrCategory = null;
            } else {
              _tmpStrCategory = _cursor.getString(_cursorIndexOfStrCategory);
            }
            _item.setStrCategory(_tmpStrCategory);
            final String _tmpStrArea;
            if (_cursor.isNull(_cursorIndexOfStrArea)) {
              _tmpStrArea = null;
            } else {
              _tmpStrArea = _cursor.getString(_cursorIndexOfStrArea);
            }
            _item.setStrArea(_tmpStrArea);
            final String _tmpStrInstructions;
            if (_cursor.isNull(_cursorIndexOfStrInstructions)) {
              _tmpStrInstructions = null;
            } else {
              _tmpStrInstructions = _cursor.getString(_cursorIndexOfStrInstructions);
            }
            _item.setStrInstructions(_tmpStrInstructions);
            final String _tmpStrMealThumb;
            if (_cursor.isNull(_cursorIndexOfStrMealThumb)) {
              _tmpStrMealThumb = null;
            } else {
              _tmpStrMealThumb = _cursor.getString(_cursorIndexOfStrMealThumb);
            }
            _item.setStrMealThumb(_tmpStrMealThumb);
            final String _tmpStrTags;
            if (_cursor.isNull(_cursorIndexOfStrTags)) {
              _tmpStrTags = null;
            } else {
              _tmpStrTags = _cursor.getString(_cursorIndexOfStrTags);
            }
            _item.setStrTags(_tmpStrTags);
            final String _tmpStrYoutube;
            if (_cursor.isNull(_cursorIndexOfStrYoutube)) {
              _tmpStrYoutube = null;
            } else {
              _tmpStrYoutube = _cursor.getString(_cursorIndexOfStrYoutube);
            }
            _item.setStrYoutube(_tmpStrYoutube);
            final String _tmpStrIngredient1;
            if (_cursor.isNull(_cursorIndexOfStrIngredient1)) {
              _tmpStrIngredient1 = null;
            } else {
              _tmpStrIngredient1 = _cursor.getString(_cursorIndexOfStrIngredient1);
            }
            _item.setStrIngredient1(_tmpStrIngredient1);
            final String _tmpStrIngredient2;
            if (_cursor.isNull(_cursorIndexOfStrIngredient2)) {
              _tmpStrIngredient2 = null;
            } else {
              _tmpStrIngredient2 = _cursor.getString(_cursorIndexOfStrIngredient2);
            }
            _item.setStrIngredient2(_tmpStrIngredient2);
            final String _tmpStrIngredient3;
            if (_cursor.isNull(_cursorIndexOfStrIngredient3)) {
              _tmpStrIngredient3 = null;
            } else {
              _tmpStrIngredient3 = _cursor.getString(_cursorIndexOfStrIngredient3);
            }
            _item.setStrIngredient3(_tmpStrIngredient3);
            final String _tmpStrIngredient4;
            if (_cursor.isNull(_cursorIndexOfStrIngredient4)) {
              _tmpStrIngredient4 = null;
            } else {
              _tmpStrIngredient4 = _cursor.getString(_cursorIndexOfStrIngredient4);
            }
            _item.setStrIngredient4(_tmpStrIngredient4);
            final String _tmpStrIngredient5;
            if (_cursor.isNull(_cursorIndexOfStrIngredient5)) {
              _tmpStrIngredient5 = null;
            } else {
              _tmpStrIngredient5 = _cursor.getString(_cursorIndexOfStrIngredient5);
            }
            _item.setStrIngredient5(_tmpStrIngredient5);
            final String _tmpStrIngredient6;
            if (_cursor.isNull(_cursorIndexOfStrIngredient6)) {
              _tmpStrIngredient6 = null;
            } else {
              _tmpStrIngredient6 = _cursor.getString(_cursorIndexOfStrIngredient6);
            }
            _item.setStrIngredient6(_tmpStrIngredient6);
            final String _tmpStrIngredient7;
            if (_cursor.isNull(_cursorIndexOfStrIngredient7)) {
              _tmpStrIngredient7 = null;
            } else {
              _tmpStrIngredient7 = _cursor.getString(_cursorIndexOfStrIngredient7);
            }
            _item.setStrIngredient7(_tmpStrIngredient7);
            final String _tmpStrIngredient8;
            if (_cursor.isNull(_cursorIndexOfStrIngredient8)) {
              _tmpStrIngredient8 = null;
            } else {
              _tmpStrIngredient8 = _cursor.getString(_cursorIndexOfStrIngredient8);
            }
            _item.setStrIngredient8(_tmpStrIngredient8);
            final String _tmpStrIngredient9;
            if (_cursor.isNull(_cursorIndexOfStrIngredient9)) {
              _tmpStrIngredient9 = null;
            } else {
              _tmpStrIngredient9 = _cursor.getString(_cursorIndexOfStrIngredient9);
            }
            _item.setStrIngredient9(_tmpStrIngredient9);
            final String _tmpStrIngredient10;
            if (_cursor.isNull(_cursorIndexOfStrIngredient10)) {
              _tmpStrIngredient10 = null;
            } else {
              _tmpStrIngredient10 = _cursor.getString(_cursorIndexOfStrIngredient10);
            }
            _item.setStrIngredient10(_tmpStrIngredient10);
            final String _tmpStrIngredient11;
            if (_cursor.isNull(_cursorIndexOfStrIngredient11)) {
              _tmpStrIngredient11 = null;
            } else {
              _tmpStrIngredient11 = _cursor.getString(_cursorIndexOfStrIngredient11);
            }
            _item.setStrIngredient11(_tmpStrIngredient11);
            final String _tmpStrIngredient12;
            if (_cursor.isNull(_cursorIndexOfStrIngredient12)) {
              _tmpStrIngredient12 = null;
            } else {
              _tmpStrIngredient12 = _cursor.getString(_cursorIndexOfStrIngredient12);
            }
            _item.setStrIngredient12(_tmpStrIngredient12);
            final String _tmpStrIngredient13;
            if (_cursor.isNull(_cursorIndexOfStrIngredient13)) {
              _tmpStrIngredient13 = null;
            } else {
              _tmpStrIngredient13 = _cursor.getString(_cursorIndexOfStrIngredient13);
            }
            _item.setStrIngredient13(_tmpStrIngredient13);
            final String _tmpStrIngredient14;
            if (_cursor.isNull(_cursorIndexOfStrIngredient14)) {
              _tmpStrIngredient14 = null;
            } else {
              _tmpStrIngredient14 = _cursor.getString(_cursorIndexOfStrIngredient14);
            }
            _item.setStrIngredient14(_tmpStrIngredient14);
            final String _tmpStrIngredient15;
            if (_cursor.isNull(_cursorIndexOfStrIngredient15)) {
              _tmpStrIngredient15 = null;
            } else {
              _tmpStrIngredient15 = _cursor.getString(_cursorIndexOfStrIngredient15);
            }
            _item.setStrIngredient15(_tmpStrIngredient15);
            final String _tmpStrIngredient16;
            if (_cursor.isNull(_cursorIndexOfStrIngredient16)) {
              _tmpStrIngredient16 = null;
            } else {
              _tmpStrIngredient16 = _cursor.getString(_cursorIndexOfStrIngredient16);
            }
            _item.setStrIngredient16(_tmpStrIngredient16);
            final String _tmpStrIngredient17;
            if (_cursor.isNull(_cursorIndexOfStrIngredient17)) {
              _tmpStrIngredient17 = null;
            } else {
              _tmpStrIngredient17 = _cursor.getString(_cursorIndexOfStrIngredient17);
            }
            _item.setStrIngredient17(_tmpStrIngredient17);
            final String _tmpStrIngredient18;
            if (_cursor.isNull(_cursorIndexOfStrIngredient18)) {
              _tmpStrIngredient18 = null;
            } else {
              _tmpStrIngredient18 = _cursor.getString(_cursorIndexOfStrIngredient18);
            }
            _item.setStrIngredient18(_tmpStrIngredient18);
            final String _tmpStrIngredient19;
            if (_cursor.isNull(_cursorIndexOfStrIngredient19)) {
              _tmpStrIngredient19 = null;
            } else {
              _tmpStrIngredient19 = _cursor.getString(_cursorIndexOfStrIngredient19);
            }
            _item.setStrIngredient19(_tmpStrIngredient19);
            final String _tmpStrIngredient20;
            if (_cursor.isNull(_cursorIndexOfStrIngredient20)) {
              _tmpStrIngredient20 = null;
            } else {
              _tmpStrIngredient20 = _cursor.getString(_cursorIndexOfStrIngredient20);
            }
            _item.setStrIngredient20(_tmpStrIngredient20);
            final String _tmpStrMeasure1;
            if (_cursor.isNull(_cursorIndexOfStrMeasure1)) {
              _tmpStrMeasure1 = null;
            } else {
              _tmpStrMeasure1 = _cursor.getString(_cursorIndexOfStrMeasure1);
            }
            _item.setStrMeasure1(_tmpStrMeasure1);
            final String _tmpStrMeasure2;
            if (_cursor.isNull(_cursorIndexOfStrMeasure2)) {
              _tmpStrMeasure2 = null;
            } else {
              _tmpStrMeasure2 = _cursor.getString(_cursorIndexOfStrMeasure2);
            }
            _item.setStrMeasure2(_tmpStrMeasure2);
            final String _tmpStrMeasure3;
            if (_cursor.isNull(_cursorIndexOfStrMeasure3)) {
              _tmpStrMeasure3 = null;
            } else {
              _tmpStrMeasure3 = _cursor.getString(_cursorIndexOfStrMeasure3);
            }
            _item.setStrMeasure3(_tmpStrMeasure3);
            final String _tmpStrMeasure4;
            if (_cursor.isNull(_cursorIndexOfStrMeasure4)) {
              _tmpStrMeasure4 = null;
            } else {
              _tmpStrMeasure4 = _cursor.getString(_cursorIndexOfStrMeasure4);
            }
            _item.setStrMeasure4(_tmpStrMeasure4);
            final String _tmpStrMeasure5;
            if (_cursor.isNull(_cursorIndexOfStrMeasure5)) {
              _tmpStrMeasure5 = null;
            } else {
              _tmpStrMeasure5 = _cursor.getString(_cursorIndexOfStrMeasure5);
            }
            _item.setStrMeasure5(_tmpStrMeasure5);
            final String _tmpStrMeasure6;
            if (_cursor.isNull(_cursorIndexOfStrMeasure6)) {
              _tmpStrMeasure6 = null;
            } else {
              _tmpStrMeasure6 = _cursor.getString(_cursorIndexOfStrMeasure6);
            }
            _item.setStrMeasure6(_tmpStrMeasure6);
            final String _tmpStrMeasure7;
            if (_cursor.isNull(_cursorIndexOfStrMeasure7)) {
              _tmpStrMeasure7 = null;
            } else {
              _tmpStrMeasure7 = _cursor.getString(_cursorIndexOfStrMeasure7);
            }
            _item.setStrMeasure7(_tmpStrMeasure7);
            final String _tmpStrMeasure8;
            if (_cursor.isNull(_cursorIndexOfStrMeasure8)) {
              _tmpStrMeasure8 = null;
            } else {
              _tmpStrMeasure8 = _cursor.getString(_cursorIndexOfStrMeasure8);
            }
            _item.setStrMeasure8(_tmpStrMeasure8);
            final String _tmpStrMeasure9;
            if (_cursor.isNull(_cursorIndexOfStrMeasure9)) {
              _tmpStrMeasure9 = null;
            } else {
              _tmpStrMeasure9 = _cursor.getString(_cursorIndexOfStrMeasure9);
            }
            _item.setStrMeasure9(_tmpStrMeasure9);
            final String _tmpStrMeasure10;
            if (_cursor.isNull(_cursorIndexOfStrMeasure10)) {
              _tmpStrMeasure10 = null;
            } else {
              _tmpStrMeasure10 = _cursor.getString(_cursorIndexOfStrMeasure10);
            }
            _item.setStrMeasure10(_tmpStrMeasure10);
            final String _tmpStrMeasure11;
            if (_cursor.isNull(_cursorIndexOfStrMeasure11)) {
              _tmpStrMeasure11 = null;
            } else {
              _tmpStrMeasure11 = _cursor.getString(_cursorIndexOfStrMeasure11);
            }
            _item.setStrMeasure11(_tmpStrMeasure11);
            final String _tmpStrMeasure12;
            if (_cursor.isNull(_cursorIndexOfStrMeasure12)) {
              _tmpStrMeasure12 = null;
            } else {
              _tmpStrMeasure12 = _cursor.getString(_cursorIndexOfStrMeasure12);
            }
            _item.setStrMeasure12(_tmpStrMeasure12);
            final String _tmpStrMeasure13;
            if (_cursor.isNull(_cursorIndexOfStrMeasure13)) {
              _tmpStrMeasure13 = null;
            } else {
              _tmpStrMeasure13 = _cursor.getString(_cursorIndexOfStrMeasure13);
            }
            _item.setStrMeasure13(_tmpStrMeasure13);
            final String _tmpStrMeasure14;
            if (_cursor.isNull(_cursorIndexOfStrMeasure14)) {
              _tmpStrMeasure14 = null;
            } else {
              _tmpStrMeasure14 = _cursor.getString(_cursorIndexOfStrMeasure14);
            }
            _item.setStrMeasure14(_tmpStrMeasure14);
            final String _tmpStrMeasure15;
            if (_cursor.isNull(_cursorIndexOfStrMeasure15)) {
              _tmpStrMeasure15 = null;
            } else {
              _tmpStrMeasure15 = _cursor.getString(_cursorIndexOfStrMeasure15);
            }
            _item.setStrMeasure15(_tmpStrMeasure15);
            final String _tmpStrMeasure16;
            if (_cursor.isNull(_cursorIndexOfStrMeasure16)) {
              _tmpStrMeasure16 = null;
            } else {
              _tmpStrMeasure16 = _cursor.getString(_cursorIndexOfStrMeasure16);
            }
            _item.setStrMeasure16(_tmpStrMeasure16);
            final String _tmpStrMeasure17;
            if (_cursor.isNull(_cursorIndexOfStrMeasure17)) {
              _tmpStrMeasure17 = null;
            } else {
              _tmpStrMeasure17 = _cursor.getString(_cursorIndexOfStrMeasure17);
            }
            _item.setStrMeasure17(_tmpStrMeasure17);
            final String _tmpStrMeasure18;
            if (_cursor.isNull(_cursorIndexOfStrMeasure18)) {
              _tmpStrMeasure18 = null;
            } else {
              _tmpStrMeasure18 = _cursor.getString(_cursorIndexOfStrMeasure18);
            }
            _item.setStrMeasure18(_tmpStrMeasure18);
            final String _tmpStrMeasure19;
            if (_cursor.isNull(_cursorIndexOfStrMeasure19)) {
              _tmpStrMeasure19 = null;
            } else {
              _tmpStrMeasure19 = _cursor.getString(_cursorIndexOfStrMeasure19);
            }
            _item.setStrMeasure19(_tmpStrMeasure19);
            final String _tmpStrMeasure20;
            if (_cursor.isNull(_cursorIndexOfStrMeasure20)) {
              _tmpStrMeasure20 = null;
            } else {
              _tmpStrMeasure20 = _cursor.getString(_cursorIndexOfStrMeasure20);
            }
            _item.setStrMeasure20(_tmpStrMeasure20);
            final String _tmpStrSource;
            if (_cursor.isNull(_cursorIndexOfStrSource)) {
              _tmpStrSource = null;
            } else {
              _tmpStrSource = _cursor.getString(_cursorIndexOfStrSource);
            }
            _item.setStrSource(_tmpStrSource);
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
