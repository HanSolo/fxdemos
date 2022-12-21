module eu.hansolo.fxdemos {
    // Java
    requires java.base;
    requires java.desktop;

    // Java-FX
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.swing;

    // 3rd Party
    requires eu.hansolo.medusa;
    requires transitive eu.hansolo.toolbox;
    requires transitive eu.hansolo.toolboxfx;

    exports eu.hansolo.fxdemos;
}