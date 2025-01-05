import { Injectable, signal, WritableSignal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Restaurant } from '../../Shared/models/Restaurant';
import { API_URL_RL } from '../../constants/url';

@Injectable({
  providedIn: 'root'
})
export class RestaurantListingService {
  data: WritableSignal<Restaurant[]> = signal([]);
  loading: WritableSignal<boolean> = signal(false);
  private apiURL = `${API_URL_RL}/restaurant/fetchAllRestaurants`;

  constructor(private http: HttpClient) { }

  getAllRestaurants(): Observable<Restaurant[]> {
    return this.http.get<Restaurant[]>(this.apiURL);
  }

  fetchAllRestaurants() {
    this.loading.set(true);
    this.getAllRestaurants().subscribe(
      (response) => {
        this.data.set(response);
        this.loading.set(false);
      },
      (error) => {
        console.error('Error fetching data:', error);
        this.loading.set(false);
      }
    );
  }

}
