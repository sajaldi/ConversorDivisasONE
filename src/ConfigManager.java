import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();

    public ConfigManager() {
    }

    public static String getApiKey() {
        return properties.getProperty("api.key");
    }

    static {
        try {
            FileInputStream fis = new FileInputStream("config.properties");

            try {
                properties.load(fis);
            } catch (Throwable var4) {
                try {
                    fis.close();
                } catch (Throwable var3) {
                    var4.addSuppressed(var3);
                }

                throw var4;
            }

            fis.close();
        } catch (IOException var5) {
            IOException e = var5;
            System.err.println("No se pudo cargar el archivo de configuración.");
            e.printStackTrace();
        }
    }
}
