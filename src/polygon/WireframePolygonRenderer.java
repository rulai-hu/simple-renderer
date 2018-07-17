package polygon;

import line.DDALineRenderer;
import line.LineRenderer;
import shading.Shaders;
import windowing.drawable.Drawable;

public class WireframePolygonRenderer implements PolygonRenderer {
	private WireframePolygonRenderer() {}

	@Override
	public void drawPolygon(Polygon polygon, Drawable drawable, Shaders shaders) {
		LineRenderer renderer = DDALineRenderer.make();
		
		polygon = shaders.shadeFace(polygon);
		
		for (int i = 0; i < polygon.numVertices; i++) {

			int next = (i + 1) % polygon.numVertices;
			renderer.drawLine(polygon.get(i), polygon.get(next), drawable);
		}
	}

	public static PolygonRenderer make() {
		return new WireframePolygonRenderer();
	}
}