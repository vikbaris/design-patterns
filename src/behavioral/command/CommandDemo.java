package behavioral.command;

public class CommandDemo {
    public static void main(String[] args) {
        // Uzaktan kumanda oluştur
        RemoteControl remote = new RemoteControl();

        // Cihazları oluştur
        Light livingRoomLight = new Light("Oturma Odası");
        Light kitchenLight = new Light("Mutfak");
        TV livingRoomTV = new TV("Oturma Odası");

        // Komutları oluştur
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
        TVOnCommand tvOn = new TVOnCommand(livingRoomTV);
        TVOffCommand tvOff = new TVOffCommand(livingRoomTV);

        // Komutları uzaktan kumandaya ata
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, tvOn, tvOff);

        // Macro komut oluştur (Tüm ışıkları aç)
        Command[] allLightsOn = {livingRoomLightOn, kitchenLightOn};
        Command[] allLightsOff = {livingRoomLightOff, kitchenLightOff};
        MacroCommand allLightsOnMacro = new MacroCommand(allLightsOn);
        MacroCommand allLightsOffMacro = new MacroCommand(allLightsOff);
        remote.setCommand(3, allLightsOnMacro, allLightsOffMacro);

        System.out.println("--- Tekli Komutlar ---");
        // Komutları çalıştır
        remote.onButtonPressed(0);  // Oturma odası ışığını aç
        remote.offButtonPressed(0); // Oturma odası ışığını kapat
        remote.onButtonPressed(2);  // TV'yi aç
        remote.undoButtonPressed(); // Son komutu geri al (TV kapanır)

        System.out.println("\n--- Macro Komut ---");
        // Macro komutu çalıştır
        remote.onButtonPressed(3);  // Tüm ışıkları aç
        remote.undoButtonPressed(); // Son komutu geri al (Tüm ışıklar kapanır)
    }
}
