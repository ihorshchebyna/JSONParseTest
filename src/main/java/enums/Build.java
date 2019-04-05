package enums;

public enum Build {
    PRODUCTION {
        public String toString() {
            return "prod";
        }
    },
    DEVELOPMENT {
        public String toString() {
            return "dev";
        }
    }
}
