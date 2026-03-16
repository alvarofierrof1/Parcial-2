/**
 * Enumeración que representa los cargos profesionales aceptados por la empresa.
 * <p>
 * Cada valor contiene un nombre legible ({@code displayName}) que se usa para mostrar en pantalla.
 * </p>
 */
public enum Cargo {
    DESARROLLADOR("Desarrollador"),
    DISEÑADORA("Diseñadora"),
    GERENTE("Gerente"),
    ADMINISTRATIVO("Administrativo");

    private final String displayName;

    Cargo(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Nombre legible del cargo.
     *
     * @return representación amigable del cargo
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Intenta mapear una cadena a un valor de {@link Cargo} comparando tanto el
     * {@link #displayName} como el nombre del enum.
     *
     * @param s cadena a mapear
     * @return el {@link Cargo} correspondiente o {@code null} si no hay coincidencia
     */
    public static Cargo fromString(String s) {
        if (s == null) return null;
        String trimmed = s.trim();
        for (Cargo c : values()) {
            if (c.displayName.equalsIgnoreCase(trimmed) || c.name().equalsIgnoreCase(trimmed)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
