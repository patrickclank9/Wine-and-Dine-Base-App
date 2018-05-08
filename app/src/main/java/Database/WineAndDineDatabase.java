package Database;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database (entities = {WineEntity.class,WineryEntity.class,StoreEntity.class,FoodEntity.class}, version = 1, exportSchema = false)
public abstract class WineAndDineDatabase extends RoomDatabase {
    public abstract WineAndDineDao myDao() ;
}

