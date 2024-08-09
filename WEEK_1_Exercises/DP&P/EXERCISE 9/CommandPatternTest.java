public class CommandPatternTest {
    public static void main(String[] args) {
        // Create the receiver
        Light light = new Light();

        // Create command objects
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Create the invoker
        RemoteControl remoteControl = new RemoteControl();

        // Turn the light on
        remoteControl.setCommand(lightOn);
        System.out.println("Issuing command to turn on the light:");
        remoteControl.pressButton();
        System.out.println();

        // Turn the light off
        remoteControl.setCommand(lightOff);
        System.out.println("Issuing command to turn off the light:");
        remoteControl.pressButton();
    }
}
