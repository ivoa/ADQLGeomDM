package net.ivoa.dm.adqlgeom.test;


/*
 * Created on 24/02/2026 by Paul Harrison (paul.harrison@manchester.ac.uk).
 */

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.geolatte.geom.G2D;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

@Converter(autoApply = true)
public class PointConverter implements AttributeConverter<org.javastro.ivoacore.pgsphere.types.Point, org.geolatte.geom.Point<G2D>> {
   @Override
   public org.geolatte.geom.Point<G2D> convertToDatabaseColumn(org.javastro.ivoacore.pgsphere.types.Point point) {
      return point(WGS84,g(point.getAlpha(), point.getDelta()));
   }

   @Override
   public org.javastro.ivoacore.pgsphere.types.Point convertToEntityAttribute(org.geolatte.geom.Point<G2D> g2DPoint) {
      return new org.javastro.ivoacore.pgsphere.types.Point(g2DPoint.getPosition().getCoordinate(0), g2DPoint.getPosition().getCoordinate(1));
   }
}
