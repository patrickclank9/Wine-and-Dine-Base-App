package Database;
import java.util.List;
public class MockDataContainer {
    private List<WineEntity> wines;
    private List<FoodEntity> foods;
    private List<WineryEntity> winery;
    private List<StoreEntity> store;
    private List<AddressEntity> address;
    public List<WineEntity> getWines() {
        return wines;
    }
    public List<FoodEntity> getFoods() {
        return foods;
    }
    public List<WineryEntity> getWinery() {
        return winery;
    }
    public List<StoreEntity> getStore() {
        return store;
    }
    public List<AddressEntity> getAddress(){
        return address;
    }
}
