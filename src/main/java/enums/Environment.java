package enums;

public enum Environment {
    WEBSITE {
        public String toString() {
            return "website";
        }
    },
    PLATFORM {
        public String toString() {
            return "platform";
        }
    }
}
