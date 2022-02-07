package player;

import java.time.LocalDate;
import java.util.Objects;

public class Player implements Actions {
    private String name;
    private String position;
    private int shirtNumber;
    private LocalDate contractUntil;

    public Player() {
    }

    public Player(String name, String position, int shirtNumber, LocalDate contractUntil) {
        this.name = name;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.contractUntil = contractUntil;
    }

    @Override
    public void wantsToSwapShirts(int num) {
        System.out.println(name + " wants to swap shirts with number " + num + ".");
    }
    @Override
    public void wantsToExtendContract(int years){
        System.out.println(name + " wants to extend his contract by " + years + " years.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public LocalDate getContractUntil() {
        return contractUntil;
    }

    public void setContractUntil(LocalDate contractUntil) {
        this.contractUntil = contractUntil;
    }

    @Override
    public String toString() {
        return "player.Player{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", shirtNumber=" + shirtNumber +
                ", contractUntil=" + contractUntil +
                '}';
    }

    public String toStringCSV() {
        return name + "," +  position + "," + shirtNumber + "," + contractUntil;
    }

    public String toStringStyle(){return name + " | " +  position + " | " + shirtNumber + " | " + contractUntil;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return shirtNumber == player.shirtNumber && Objects.equals(name, player.name) && Objects.equals(position, player.position) && Objects.equals(contractUntil, player.contractUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, shirtNumber, contractUntil);
    }
}
