import {Injectable, signal, Signal, WritableSignal} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {API_URL_RL} from '../../constants/url';

@Injectable({
  providedIn: 'root'
})
export class RestaurantListingService {
  data: WritableSignal<any> = signal(null);
  loading: WritableSignal<boolean> = signal(false);

  private apiURL = API_URL_RL+'/restaurant/fetchAllRestaurants';

  constructor(private http:HttpClient) { }
  fetchData(){
    this.loading.set(true);
    this.http.get(this.apiURL).subscribe(
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
