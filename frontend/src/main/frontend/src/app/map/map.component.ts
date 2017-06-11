import {Component, Input} from '@angular/core';


@Component({
  selector: 'map',
  template: `<sebm-google-map [latitude]="lat" [longitude]="lng"  class="map">
  <sebm-google-map-marker [latitude]="lat" [longitude]="lng"></sebm-google-map-marker>
</sebm-google-map>
`

})

export class MapComponent {
  @Input() lat: number;
  @Input() lng: number;
}
