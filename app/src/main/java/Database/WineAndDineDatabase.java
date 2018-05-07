package Database;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database (entities = {WineEntity.class,WineryEntity.class,StoreEntity.class,FoodEntity.class,AddressEntity.class}, version = 1, exportSchema = false)
public abstract class WineAndDineDatabase extends RoomDatabase {
    public abstract WineAndDineDao myDao() ;
}



/*
@Database(entities = {WineEntity.class,WineryEntity.class,StoreEntity.class,FoodEntity.class,AddressEntity.class}, version = 1, exportSchema = false)
public abstract class WineAndDineDatabase extends RoomDatabase {
    private static WineAndDineDatabase db;
    public abstract WineAndDineDao WineAndDineDao();

    public static WineAndDineDatabase getWineAndDineDatabase(Context context){
        if(db==null){
            db=Room.databaseBuilder(
                    context.getApplicationContext(),
                    WineAndDineDatabase.class,
                    "wineandwine-db").allowMainThreadQueries().build();
        }
        return db;
    }
    public static void destroyInstance() {db=null;}
}


*/