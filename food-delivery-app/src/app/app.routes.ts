import {Routes} from '@angular/router';
import {FoodCatalogueComponent} from './food-catalouge/component/food-catalogue.component';

export const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./restaurant-listing/module/restaurant-listing.module').then(m => m.RestaurantListingModule)
  },
  {
    path: 'food-catalogue/:id',
    component: FoodCatalogueComponent
  }
];
