import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {FoodCatalogueComponent} from '../component/food-catalogue.component';
import {FoodItemService} from '../service/food-item.service';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule,
    FoodCatalogueComponent
  ],
  providers: [FoodItemService]
})
export class FoodCatalogueModule { }
