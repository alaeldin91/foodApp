package com.example.foodapp.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FoodDb_Impl extends FoodDb {
  private volatile MealRandomItemDao _mealRandomItemDao;

  private volatile CategoryItemDao _categoryItemDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `mealDb` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idMeal` TEXT, `strMeal` TEXT, `strCategory` TEXT, `strArea` TEXT, `strInstructions` TEXT, `strMealThumb` TEXT, `strTags` TEXT, `strYoutube` TEXT, `strIngredient1` TEXT, `strIngredient2` TEXT, `strIngredient3` TEXT, `strIngredient4` TEXT, `strIngredient5` TEXT, `strIngredient6` TEXT, `strIngredient7` TEXT, `strIngredient8` TEXT, `strIngredient9` TEXT, `strIngredient10` TEXT, `strIngredient11` TEXT, `strIngredient12` TEXT, `strIngredient13` TEXT, `strIngredient14` TEXT, `strIngredient15` TEXT, `strIngredient16` TEXT, `strIngredient17` TEXT, `strIngredient18` TEXT, `strIngredient19` TEXT, `strIngredient20` TEXT, `strMeasure1` TEXT, `strMeasure2` TEXT, `strMeasure3` TEXT, `strMeasure4` TEXT, `strMeasure5` TEXT, `strMeasure6` TEXT, `strMeasure7` TEXT, `strMeasure8` TEXT, `strMeasure9` TEXT, `strMeasure10` TEXT, `strMeasure11` TEXT, `strMeasure12` TEXT, `strMeasure13` TEXT, `strMeasure14` TEXT, `strMeasure15` TEXT, `strMeasure16` TEXT, `strMeasure17` TEXT, `strMeasure18` TEXT, `strMeasure19` TEXT, `strMeasure20` TEXT, `strSource` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `categoryDb` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `idCategory` TEXT, `strCategory` TEXT, `strCategoryThumb` TEXT, `strCategoryDescription` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'afea15e11f2d49c610b93d6dd53bdbaa')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `mealDb`");
        _db.execSQL("DROP TABLE IF EXISTS `categoryDb`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsMealDb = new HashMap<String, TableInfo.Column>(50);
        _columnsMealDb.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("idMeal", new TableInfo.Column("idMeal", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeal", new TableInfo.Column("strMeal", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strCategory", new TableInfo.Column("strCategory", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strArea", new TableInfo.Column("strArea", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strInstructions", new TableInfo.Column("strInstructions", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMealThumb", new TableInfo.Column("strMealThumb", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strTags", new TableInfo.Column("strTags", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strYoutube", new TableInfo.Column("strYoutube", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient1", new TableInfo.Column("strIngredient1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient2", new TableInfo.Column("strIngredient2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient3", new TableInfo.Column("strIngredient3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient4", new TableInfo.Column("strIngredient4", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient5", new TableInfo.Column("strIngredient5", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient6", new TableInfo.Column("strIngredient6", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient7", new TableInfo.Column("strIngredient7", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient8", new TableInfo.Column("strIngredient8", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient9", new TableInfo.Column("strIngredient9", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient10", new TableInfo.Column("strIngredient10", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient11", new TableInfo.Column("strIngredient11", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient12", new TableInfo.Column("strIngredient12", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient13", new TableInfo.Column("strIngredient13", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient14", new TableInfo.Column("strIngredient14", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient15", new TableInfo.Column("strIngredient15", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient16", new TableInfo.Column("strIngredient16", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient17", new TableInfo.Column("strIngredient17", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient18", new TableInfo.Column("strIngredient18", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient19", new TableInfo.Column("strIngredient19", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strIngredient20", new TableInfo.Column("strIngredient20", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure1", new TableInfo.Column("strMeasure1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure2", new TableInfo.Column("strMeasure2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure3", new TableInfo.Column("strMeasure3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure4", new TableInfo.Column("strMeasure4", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure5", new TableInfo.Column("strMeasure5", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure6", new TableInfo.Column("strMeasure6", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure7", new TableInfo.Column("strMeasure7", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure8", new TableInfo.Column("strMeasure8", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure9", new TableInfo.Column("strMeasure9", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure10", new TableInfo.Column("strMeasure10", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure11", new TableInfo.Column("strMeasure11", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure12", new TableInfo.Column("strMeasure12", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure13", new TableInfo.Column("strMeasure13", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure14", new TableInfo.Column("strMeasure14", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure15", new TableInfo.Column("strMeasure15", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure16", new TableInfo.Column("strMeasure16", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure17", new TableInfo.Column("strMeasure17", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure18", new TableInfo.Column("strMeasure18", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure19", new TableInfo.Column("strMeasure19", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strMeasure20", new TableInfo.Column("strMeasure20", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMealDb.put("strSource", new TableInfo.Column("strSource", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMealDb = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMealDb = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMealDb = new TableInfo("mealDb", _columnsMealDb, _foreignKeysMealDb, _indicesMealDb);
        final TableInfo _existingMealDb = TableInfo.read(_db, "mealDb");
        if (! _infoMealDb.equals(_existingMealDb)) {
          return new RoomOpenHelper.ValidationResult(false, "mealDb(com.example.foodapp.model.MealItem).\n"
                  + " Expected:\n" + _infoMealDb + "\n"
                  + " Found:\n" + _existingMealDb);
        }
        final HashMap<String, TableInfo.Column> _columnsCategoryDb = new HashMap<String, TableInfo.Column>(5);
        _columnsCategoryDb.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategoryDb.put("idCategory", new TableInfo.Column("idCategory", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategoryDb.put("strCategory", new TableInfo.Column("strCategory", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategoryDb.put("strCategoryThumb", new TableInfo.Column("strCategoryThumb", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategoryDb.put("strCategoryDescription", new TableInfo.Column("strCategoryDescription", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategoryDb = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCategoryDb = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCategoryDb = new TableInfo("categoryDb", _columnsCategoryDb, _foreignKeysCategoryDb, _indicesCategoryDb);
        final TableInfo _existingCategoryDb = TableInfo.read(_db, "categoryDb");
        if (! _infoCategoryDb.equals(_existingCategoryDb)) {
          return new RoomOpenHelper.ValidationResult(false, "categoryDb(com.example.foodapp.model.CategoryItem).\n"
                  + " Expected:\n" + _infoCategoryDb + "\n"
                  + " Found:\n" + _existingCategoryDb);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "afea15e11f2d49c610b93d6dd53bdbaa", "13d9ed1ac207345475d392ea0c5c9e6b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "mealDb","categoryDb");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `mealDb`");
      _db.execSQL("DELETE FROM `categoryDb`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MealRandomItemDao.class, MealRandomItemDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CategoryItemDao.class, CategoryItemDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public MealRandomItemDao mealRandomItemDao() {
    if (_mealRandomItemDao != null) {
      return _mealRandomItemDao;
    } else {
      synchronized(this) {
        if(_mealRandomItemDao == null) {
          _mealRandomItemDao = new MealRandomItemDao_Impl(this);
        }
        return _mealRandomItemDao;
      }
    }
  }

  @Override
  public CategoryItemDao categoryItemDao() {
    if (_categoryItemDao != null) {
      return _categoryItemDao;
    } else {
      synchronized(this) {
        if(_categoryItemDao == null) {
          _categoryItemDao = new CategoryItemDao_Impl(this);
        }
        return _categoryItemDao;
      }
    }
  }
}
