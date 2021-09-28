# NewsAppV2
Rework NewsApp with heavy emphasis on MVP

Improvements:
  1. Fixed the design of the app to be more in line with proposed figma design
  2. Reworked the Presenter. Now every activity has its own presenter
  3. Reworked the recycler views, data is now stored in the presenter and the adapter calls on the presenter for data
  4. Implemented proper gradient for text views in the article list
  5. Moved all data handling to the model repository
  6. Optimized the recycler views so the adapters only update instead of recreating themselves
