import { PostLineStep, step } from "../testPost";

export const backendTestSteps: PostLineStep[] = [
  step(/there is your player/, () => {}),
  step(/there is the player "[^"]+"( with password "[^"]+")?/, () => {}),
  step(/"[^"]+" has created the game "[^"]+"/, () => {}),
  step(/you have created the game "[^"]+"/, () => {}),
  step(/there is a game "[^"]+" created by "[^"]+"/, () => {}),
  step(/there are players "[^"]+"/, () => {}),
  step(/"[^"]+" has joined the game "[^"]+" created by "[^"]+"/, () => {}),
];
