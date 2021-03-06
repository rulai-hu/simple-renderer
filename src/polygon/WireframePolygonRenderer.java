package polygon;

import line.DDALineRenderer;
import line.LineRenderer;
import shading.PixelShader;
import windowing.drawable.Drawable;

public class WireframePolygonRenderer implements PolygonRenderer {
	final private static LineRenderer renderer = DDALineRenderer.make();
	private WireframePolygonRenderer() {}

	@Override
	public void drawPolygon(Polygon polygon, Drawable drawable, PixelShader pixelShader) {		
		for (int i = 0; i < polygon.numVertices; i++) {
			int next = (i + 1) % polygon.numVertices;
			renderer.drawLine(polygon.get(i), polygon.get(next), drawable);
		}
	}

	public static PolygonRenderer make() {
		return new WireframePolygonRenderer();
	}
}