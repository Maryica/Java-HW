package HW6;
import java.util.*;
public class HomeWork6 {
    private static Set<Laptop> laptops;

    public static void main(String[] args) {

        laptops = new HashSet<>();

        laptops.add(createLaptop(8, 128, "Windows", "black"));
        laptops.add(createLaptop(8, 256, "Windows", "grey"));
        laptops.add(createLaptop(16, 512, "Windows", "grey"));
        laptops.add(createLaptop(16, 1024, "Windows", "black"));
        laptops.add(createLaptop(32, 1024, "Windows", "white"));
        laptops.add(createLaptop(8, 512, "Linux", "black"));
        laptops.add(createLaptop(16, 1024, "Linux", "grey"));
        laptops.add(createLaptop(32, 1024, "Linux", "white"));
        laptops.add(createLaptop(16, 512, "MacOS", "white"));
        laptops.add(createLaptop(32, 1024, "MacOS", "black"));
        laptops.add(createLaptop(64, 2048, "MacOS", "grey"));


        Map<String, Object> filterCriterion = filterCriterionUser();
        Set<Laptop> filteredLaptops = filterLaptops(filterCriterion);
        printFilterLaptops(filteredLaptops);
    }


    public static Laptop createLaptop(int ram, int hardDrive, String os, String color) {
        Laptop laptop = new Laptop();
        laptop.setRam(ram);
        laptop.setHardDrive(hardDrive);
        laptop.setOs(os);
        laptop.setColor(color);
        return laptop;
    }


    private static Map<String, Object> filterCriterionUser() {
        Map<String, Object> filterCriteron = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите минимальный ОЗУ или оставьте пустым: ");
        String ram = scanner.nextLine();
        if (!(ram.isEmpty())) {
            int minRam = Integer.parseInt(ram);
            filterCriteron.put("ram", minRam);
        }

        System.out.print("Введите минимальный объем ЖД или оставьте пустым: ");
        String hardDrive = scanner.nextLine();
        if (!(hardDrive.isEmpty())) {
            int minHardDrive = Integer.parseInt(hardDrive);
            filterCriteron.put("hardDrive", minHardDrive);
        }

        System.out.print("Введите операционную систему или оставьте пустым: ");
        String os = scanner.nextLine();
        if (!(os.isEmpty())) {
            filterCriteron.put("os", os);
        }

        System.out.print("Введите цвет или оставьте пустым: ");
        String color = scanner.nextLine();
        if (!(color.isEmpty())) {
            filterCriteron.put("color", color);
        }

        return filterCriteron;
    }
    private static Set<Laptop> filterLaptops(Map<String, Object> filterCriterion) {
        Set<Laptop> filteredLaptops = new HashSet<>();

        for (Laptop laptop : laptops) {
            boolean meetsCriterion = true;

            if (filterCriterion.containsKey("ram")) {
                int minRam = (int) filterCriterion.get("ram");
                if (laptop.getRam() < minRam) {
                    meetsCriterion = false;
                }
            }

            if (filterCriterion.containsKey("hardDrive")) {
                int minHardDrive = (int) filterCriterion.get("hardDrive");
                if (laptop.getHardDrive() < minHardDrive) {
                    meetsCriterion = false;
                }
            }

            if (filterCriterion.containsKey("os")) {
                String os = (String) filterCriterion.get("os");
                if (!laptop.getOs().equals(os)) {
                    meetsCriterion = false;
                }
            }

            if (filterCriterion.containsKey("color")) {
                String color = (String) filterCriterion.get("color");
                if (!laptop.getColor().equals(color)) {
                    meetsCriterion = false;
                }
            }

            if (meetsCriterion) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }

    private static void printFilterLaptops(Set<Laptop> laptops) {
        if (laptops.isEmpty()) {
            System.out.println("Необходимые ноутбуки не найдены.");
        } else {
            System.out.println("Фильтр:");
            laptops.forEach(System.out::println);
        }
    }
}
