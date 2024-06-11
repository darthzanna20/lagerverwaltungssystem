package ch.projektgruppe2.detailhandel.business;

public class BCProduct implements Product {
    private long id;
    private String name;
    private String description;
    private int inventory;

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public int getInventory() {
        return inventory;
    }
}

