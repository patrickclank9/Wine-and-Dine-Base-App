package Database;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

@Database (entities = {WineEntity.class,WineryEntity.class,StoreEntity.class,FoodEntity.class}, version = 1, exportSchema = false)
public abstract class WineAndDineDatabase extends RoomDatabase {
    public abstract WineAndDineDao myDao() ;

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }
}



