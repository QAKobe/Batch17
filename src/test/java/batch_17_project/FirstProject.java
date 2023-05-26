package batch_17_project;

public class FirstProject {

    public static void main(String[] args) {

        // minutes to years
        int minutes = 3456789; // Replace with your desired value

        int minutesInDay = 24 * 60;
        int minutesInYear = 365 * minutesInDay;

        int years = minutes / minutesInYear;
        int remainingMinutes = minutes % minutesInYear;
        int days = remainingMinutes / minutesInDay;

        System.out.println(minutes + " minutes is approximately " + years + " years and " + days + " days.");

    }

}
