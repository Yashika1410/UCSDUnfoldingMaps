import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.data.*;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class EarthquakeCityMap extends PApplet
{
	private UnfoldingMap map;
	public void setup() {
		
		size(950,600,OPENGL);
		map = new UnfoldingMap(this,200,50,700,500,new Google.GoogleMapProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
	 Location valLoc = new Location(-38,14f);
	  Feature valEq = new PointFeature(valLoc);
	  valEq.addProperty("title","Valdivia,Chile");
	  valEq.addProperty("magnitude","9.5");
	  valEq.addProperty("date","May 22,1960");
	  valEq.addProperty("year","1960");
	  
	  Marker valMk = new SimplePointMarker(valLoc ,valEq.getProperties());
	  
	  map.addMarker(valMk);
	  List <PointFeature> bigEqs = new ArrayList<PointFeature>();
	  bigEqs.add((PointFeature) valEq);
	  PointFeature alaskaEq = null;
	bigEqs.add(alaskaEq);
	  PointFeature sumatraEq = null;
	bigEqs.add(sumatraEq);
	  PointFeature japanEq = null;
	bigEqs.add(japanEq);
	  PointFeature kamchatkaEq = null;
	bigEqs.add(kamchatkaEq); 
	
	List<Marker> markers = new ArrayList<Marker>();
	for (PointFeature eq: bigEqs) {
		markers.add(new SimplePointMarker(eq.getLocation(),eq.getProperties()));
		int yellow = color(255,255,0);
		int gray = color(150,150,150);
		for(Marker mk : markers) {
			if ( (int) mk.getProperty("year") > 2000 ) {
				mk.setColor(yellow);
			}
			else {
				mk.setColor(gray);
			}
		}
		
		
		
		
	}
	Marker arg0 = null;
	map.addMarkers(arg0);
	 
	}
    public void draw() {
    	background(10);
    	map.draw();
     	addKey();
    }
	private void addKey() {
		// TODO Auto-generated method stub
		
	}
}
