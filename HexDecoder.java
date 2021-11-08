public class HexDecoder {

    private String hex = "", binary = "";
    private double decimal = 0;

    public void setHex(String hex) {
        this.hex = hex;

        binary = hexToBinary(hex);
        binaryEncoder(binary);
    }

    public double getDecimal() {
        return decimal;
    }

    public String getBinary() {
        return binary;
    }

    private void binaryEncoder(String binary) {
        int vz = Integer.parseInt(String.valueOf(binary.charAt(0)));
        binary = binary.substring(1);
        int c = Integer.parseInt(binary.substring(0, 8));
        int e = binaryToDecimal(String.valueOf(c)) - 127;
        binary = binary.substring(8);
        double m = Double.parseDouble(String.valueOf(1 + binaryFloatToDecimal(binary)));

        decimal = Math.pow(-1, vz) * m * Math.pow(2, e);
    }

    private int binaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    private double binaryFloatToDecimal(String binaryFloat) {
        double result = 0.0;
        for (int i = 1; i < binaryFloat.length() + 1; i++) {
            int bit = Integer.parseInt(String.valueOf(binaryFloat.charAt(i - 1)));
            result += bit * Math.pow(2, -i);
        }
        return result;
    }

    private String hexToBinary(String hex) {
        hex = hex.toUpperCase();
        hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("A", "1010");
        hex = hex.replaceAll("B", "1011");
        hex = hex.replaceAll("C", "1100");
        hex = hex.replaceAll("D", "1101");
        hex = hex.replaceAll("E", "1110");
        hex = hex.replaceAll("F", "1111");
        return hex;
    }
}
