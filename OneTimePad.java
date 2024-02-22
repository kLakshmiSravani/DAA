import java.security.SecureRandom;

public class OneTimePad {
    public static void main(String[] args) {
        String message = "HELLO";
        String key = generateRandomKey(message.length());

        System.out.println("Original Message: " + message);

        // Encrypt the message
        String ciphertext = encrypt(message, key);
        System.out.println("Encrypted Message: " + ciphertext);

        // Decrypt the message
        String decryptedMessage = decrypt(ciphertext, key);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

    // Function to generate a random key of the specified length
    private static String generateRandomKey(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < length; i++) {
            key.append((char) (random.nextInt(26) + 'A')); // Generating random uppercase letters
        }

        return key.toString();
    }

    // Function to perform OTP encryption
    private static String encrypt(String message, String key) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            char keyChar = key.charAt(i);

            // XOR operation between message and key
            char encryptedChar = (char) (messageChar ^ keyChar);

            ciphertext.append(encryptedChar);
        }

        return ciphertext.toString();
    }

    // Function to perform OTP decryption
    private static String decrypt(String ciphertext, String key) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char ciphertextChar = ciphertext.charAt(i);
            char keyChar = key.charAt(i);

            // XOR operation between ciphertext and key
            char decryptedChar = (char) (ciphertextChar ^ keyChar);

            decryptedMessage.append(decryptedChar);
        }

        return decryptedMessage.toString();
    }
}
