import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./restaurant-listing/module/restaurant-listing.module').then(m => m.RestaurantListingModule)
  }

];
