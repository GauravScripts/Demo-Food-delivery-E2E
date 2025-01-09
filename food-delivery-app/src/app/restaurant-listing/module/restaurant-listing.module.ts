// restaurant-listing.module.ts
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';  // Add this import
import { RestaurantListingRoutingModule } from './restaurant-listing-routing.module';
import { RestaurantListingComponent } from '../component/restaurant-listing.component';
import { RestaurantListingService } from '../service/restaurant-listing.service';

@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    HttpClientModule,  // Add HttpClientModule
    RestaurantListingRoutingModule
  ],
  providers: [RestaurantListingService]
})
export class RestaurantListingModule { }
