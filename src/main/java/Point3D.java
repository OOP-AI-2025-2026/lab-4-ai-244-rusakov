package ua.opnu.java.inheritance;

import ua.opnu.java.inheritance.geometry.Point;

public class Point3D extends Point {
    private int z;

    public Point3D() {
        super();
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return this.z;
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0;
    }

    public double distance(Point3D p) {
        int dx = getX() - p.getX();
        int dy = getY() - p.getY();
        int dz = this.z - p.getZ();

        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double distanceFromOrigin() {
        int x = getX();
        int y = getY();
        int z = this.z;

        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + this.z + ")";
    }
}
