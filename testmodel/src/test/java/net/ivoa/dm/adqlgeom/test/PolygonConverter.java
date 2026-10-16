package net.ivoa.dm.adqlgeom.test;


import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.geolatte.geom.G2D;
import org.javastro.ivoacore.pgsphere.types.Polygon;

import static org.geolatte.geom.builder.DSL.*;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

@Converter(autoApply = true)
public class PolygonConverter implements AttributeConverter<Polygon, org.geolatte.geom.Polygon<G2D>> {

    @Override
    public org.geolatte.geom.Polygon<G2D> convertToDatabaseColumn(Polygon pgon) {
        if (pgon == null) {
           return null;
        }
        return polygon(WGS84,ring(
                pgon.getPoints().stream()
                        .map(p -> g(p.getAlpha(), p.getDelta()))
                        .toArray(G2D[]::new))
        );
    }

    @Override
    public Polygon convertToEntityAttribute(org.geolatte.geom.Polygon<G2D> g2DPolygon) {
        if (g2DPolygon == null) {
            return null;
        }
        // FIXME need to think about the exterior/interior ring and do this properly?
        Polygon pgon = new Polygon();
        pgon.setPoints(g2DPolygon.getExteriorRing().getPositions().stream()
                .map(pos -> new org.javastro.ivoacore.pgsphere.types.Point(pos.getCoordinate(0), pos.getCoordinate(1)))
                .toList()
        );
        return pgon;
    }
}
