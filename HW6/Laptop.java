package HW6;
public class Laptop {
    private int ram;
    private int hardDrive;
    private String os;
    private String color;

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(int hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return
                "ОЗУ: \t" + ram +
                        ",\t ЖД: \t" + hardDrive +
                        ",\t Цвет: \t" + color+
                        ",\t OC: \t" + os;
    }
}
